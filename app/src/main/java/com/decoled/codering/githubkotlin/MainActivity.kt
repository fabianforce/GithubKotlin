package com.decoled.codering.githubkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.decoled.codering.githubkotlin.Api.GithubApiService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), View.OnClickListener, Callback<ResponseBody> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       Login()
    }

    private fun Login() {
        val posting = GithubApiService.create()
        posting.login(txt_user.text.toString(), txt_password.text.toString()).enqueue(this)
    }

    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        Toast.makeText(baseContext ,txt_user.text.toString() + t.localizedMessage , Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        Toast.makeText(baseContext , txt_user.text.toString() + response.body().toString(), Toast.LENGTH_LONG).show()
    }

}
