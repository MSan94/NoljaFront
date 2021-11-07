package com.prj.nolja.view.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.prj.nolja.MyApplication
import com.prj.nolja.data.model.User
import com.prj.nolja.data.repository.user.UserRepository
import org.mindrot.jbcrypt.BCrypt

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    val valid = MutableLiveData<Boolean>()
    val resultText = MutableLiveData<String>()

    /** 로그인정보 유무 조회 **/
    init{
        val prefsId = MyApplication.prefs.getString("ID","noId")
        /*MyApplication.prefs.deleteString("ID")*/
        if(prefsId != "noId"){
            resultText.postValue("success")
        }
        Log.d("Test",prefsId)
    }

    /** 로그인 **/
    fun selectUser(id:String, pw:String){
        UserRepository.selectUser(id,pw, object : UserRepository.getDataCallback<User>{
            override fun onSuccess(data: User?) {
                data?.let {
                    valid.value = !(it.result).equals("fail")
                    resultText.value = it.result
                    MyApplication.prefs.setString("ID",id)
                }
            }

            override fun onFailure(throwable: Throwable) {
                throwable.printStackTrace()
            }

        })
    }

    companion object {
        fun getDigestSalt(password: String): String {
            return BCrypt.hashpw(password, BCrypt.gensalt(10))
        }
    }

}