package com.prj.nolja.view.viewmodel

import android.app.Application
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prj.nolja.data.model.CommonModel
import com.prj.nolja.data.repository.user.UserRepository
import com.prj.nolja.util.Event
import org.mindrot.jbcrypt.BCrypt

class JoinViewModel() : ViewModel() {

    /** 정규식 **/

    /** SqlInject **/

    /** XXS **/

    private val _err = MutableLiveData<Event<String>>()
    val err : LiveData<Event<String>>
        get() = _err

    /** 아이디 체크 **/
    private val _idCheck = MutableLiveData<Int>(-1)
    val idCheck: LiveData<Int>
        get() = _idCheck
    /** 이메일 체크 **/
    private val _emailCheck = MutableLiveData<Boolean>(false)
    val emailCheck: LiveData<Boolean>
        get() = _emailCheck
    /** 회원가입 결과 **/
    private val _joinResult = MutableLiveData<Int>()
    val joinResult : LiveData<Int>
        get() = _joinResult
    /** 메일 카운트 다운 **/
    private val _mailTimer = MutableLiveData<String>()
    val mailTime : LiveData<String>
        get() = _mailTimer
    /** 메일 String **/
    private val _mailString = MutableLiveData<String>()
    val mailString : LiveData<String>
        get() = _mailString

    fun selectId(id: String) {
        if (id.length < 5) {
            handleError("",Throwable("아이디는 5글자 이상 작성해주세요."))
        }else {
            UserRepository.validUserId(id, object : UserRepository.getDataCallback<CommonModel> {
                override fun onSuccess(data: CommonModel?) {
                    data?.let {
                        _idCheck.postValue(it.result)
                    }
                }
                override fun onFailure(throwable: Throwable) {
                    throwable.printStackTrace()
                }
            })
        }
    }

    fun sendMail(receiverMail:String) {
        _emailCheck.postValue(true)
        requestMail(receiverMail)
        val countDown = object : CountDownTimer(1000 * 180 , 1000){
            override fun onTick(millisUntilFinished: Long) {
                _mailTimer.postValue((millisUntilFinished/1000).toString() + "초 남았습니다.")
            }
            override fun onFinish() {
                /** 타이머 끝나면 메일 처리 **/
            }
        }.start()
    }
    /** 메일 요청 **/
    fun requestMail(receiverMail:String){
        UserRepository.requestMail(receiverMail, object : UserRepository.getDataCallback<CommonModel>{
            override fun onSuccess(data: CommonModel?) {
                data?.let {
                    _mailString.postValue(it.mailString)
                }
            }
            override fun onFailure(throwable: Throwable) {
                throwable.printStackTrace()
            }

        })
    }

    fun regitUser(id:String, pw:String, pwCheck:String, nickName:String, email:String, mailCode:String){
        if(_idCheck.value == 1){
            handleError("", Throwable("아이디를 확인해주세요."))
            return
        }
        if(!pwCheck.equals(pw)){
            handleError("", Throwable("비밀번호를 확인해주세요."))
            return
        }
        if(nickName.length < 2){
            handleError("", Throwable("닉네임을 3글자 이상 작성해주세요."))
            return
        }
        if(email.length < 5){
            handleError("", Throwable("이메일을 정확히 입력해주세요."))
            return
        }
        if(_emailCheck.value == false){
            handleError("", Throwable("이메일을 코드를 인증해주세요."))
            return
        }
        if(_mailString.value != mailCode){
            handleError("", Throwable("인증코드를 확인해주세요."))
            Log.d("TestMail", "값:$_mailString")
            return
        }
        UserRepository.insertUser(id,pw,nickName,email,object : UserRepository.getDataCallback<CommonModel>{
            override fun onSuccess(data: CommonModel?) {
                data?.let {
                    if(it.result > 0) {
                        _joinResult.postValue(1) // 성공
                    }else{
                        _joinResult.postValue(0) // 실패
                    }
                }
            }
            override fun onFailure(throwable: Throwable) {
                throwable.printStackTrace()
            }
        })
    }

    private fun handleError(message:String,exception: Throwable) {
        val message = exception.message ?: message
        _err.value = Event(message)
    }


    /** 서버에서 처리.. 서버로 전송할때는 어떻게 암호화 하는지 확인해보자.. **/
/*    companion object {
        fun getDigestSalt(password: String): String {
            return BCrypt.hashpw(password, BCrypt.gensalt(10))
        }
    }*/
}