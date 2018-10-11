package com.decoled.codering.githubkotlin

import android.content.Intent
import android.net.Uri
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

    var clientID = "359db5ebe639b78226ce"
    var ClientSecret = "9d21d8f058e7bccda39fbe8c5f042ca386f4efa0"
    var redirectUri = "fabian://callback"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login!!.setOnClickListener(this)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/login/oauth/authorize?client_id=" +
                "$clientID&scope=repo&redirect_uri=$redirectUri"))
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        Login()
    }

    private fun Login() {
        val posting = GithubApiService.create()
        posting.login(clientID, ClientSecret, "").enqueue(this)
    }

    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        Toast.makeText(baseContext, "msg" + t.localizedMessage, Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        Toast.makeText(baseContext, "msg" + response.code(), Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        //var url = intent.data
    }

}
