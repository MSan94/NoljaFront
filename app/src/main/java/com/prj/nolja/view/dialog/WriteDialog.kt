package com.prj.nolja.view.dialog

import android.R.attr
import android.app.Activity.RESULT_OK
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Point
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.prj.nolja.MyApplication
import com.prj.nolja.data.model.BoardModel
import com.prj.nolja.data.model.CommonModel
import com.prj.nolja.data.repository.board.BoardRepository
import com.prj.nolja.data.repository.user.UserRepository
import com.prj.nolja.databinding.DialogWriteBinding
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.File


class WriteDialog : DialogFragment() {
    private var _binding : DialogWriteBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DialogWriteBinding.inflate(inflater,container,false)
        binding.btnFile.setOnClickListener {
//            onPermission()
        }
        binding.btnClose.setOnClickListener {
            dismiss()
        }
        binding.btnRegister.setOnClickListener {
            val writer = MyApplication.prefs.getString("ID","알수없음")
            val subject = binding.editTextWrite.text.toString()
            val gender = "M" // 임시
            val imgfile = ""

            BoardRepository.insertBoard(writer,subject,gender,imgfile,object : BoardRepository.getDataCallback<BoardModel>{
                override fun onSuccess(data: BoardModel?) {
                    data?.let {
                        if(it.result == "1"){
                            Toast.makeText(activity,"등록되었습니다.",Toast.LENGTH_SHORT).show()
                            dismiss()
                        }else{
                            Toast.makeText(activity,"장애가 발생했습니다. 관리자에게 문의해주세요.",Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(throwable: Throwable) {
                    throwable.printStackTrace()
                }

            })

//            if(destfile != null) {
//                sendData(destfile)
//            }else{
//                sendData(null)
//            }
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        context?.dialogFragmentResize(this@WriteDialog, 0.9f, 0.9f)
    }

    fun Context.dialogFragmentResize(dialogFragment: DialogFragment, width: Float, height: Float) {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

        if (Build.VERSION.SDK_INT < 30) {

            val display = windowManager.defaultDisplay
            val size = Point()

            display.getSize(size)

            val window = dialogFragment.dialog?.window

            val x = (size.x * width).toInt()
            val y = (size.y * height).toInt()
            window?.setLayout(x, y)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

//    fun onPermission(){
//        var cameraPermission = context?.let { ContextCompat.checkSelfPermission(it, android.Manifest.permission.CAMERA) }
//        if(cameraPermission == PackageManager.PERMISSION_DENIED){
//            requestPermission()
//        }else{
//            selectCamera()
//        }
//    }
//    fun requestPermission(){
//        ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.CAMERA), 99)
//    }
//
//    fun selectCamera(){
//        val SELECT_PICTURE : Int = 200;
//        var state = Environment.getExternalStorageState()
//        if(TextUtils.equals(state,Environment.MEDIA_MOUNTED)){
//            var intent = Intent(Intent.ACTION_GET_CONTENT)
//            intent.setType("image/*")
//            startActivityForResult(Intent.createChooser(intent,"Select"),SELECT_PICTURE)
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(resultCode == RESULT_OK){
//            if(requestCode == 200){
//                var selectImg : Uri = data!!.data
//                binding.imageViewImg.setImageURI(selectImg)
//                val uri : Uri = data!!.data
//                binding.imageViewImg.setImageURI(uri)
//                val imagePath : String = uri.path
//                destfile = File(imagePath)
//
//            }
//        }
//    }
//
//    fun sendData(destfile : File?){
//        val requestBmp: RequestBody
//        val bmp : MultipartBody.Part?
//        if(destfile != null) {
//            requestBmp = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), destfile)
//            bmp = MultipartBody.Part.createFormData("imgfile",destfile?.path,requestBmp)
//            Log.d("TestApp2" , "${bmp.toString()}")
//        }
//        val writer = MyApplication.prefs.getString("ID","noId")
//        val subject = binding.editTextWrite.text.toString()
//        val type = "M"
//
//        Log.d("TestApp2" , "$writer $subject $type")
//        //TODO RETROFIT INSERT
//    }
//
//
//    companion object{
//        var destfile : File? = null
//    }
}