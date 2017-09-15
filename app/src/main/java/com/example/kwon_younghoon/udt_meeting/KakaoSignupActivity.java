package com.example.kwon_younghoon.udt_meeting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.helper.log.Logger;

/**
 * Created by kwon-younghoon on 2017. 9. 10..
 */

public class KakaoSignupActivity extends Activity{

    @Override
    protected void onCreate(final Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        recreate();
    }

    protected void requestMe() {
        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult){
                String message = "failed to get user info msg=" + errorResult;
                Logger.d(message);
            }
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                redirectLoginActivity();
            }

            @Override
            public void onNotSignedUp() {

            }

            @Override
            public void onSuccess(UserProfile userProfile) {
                Logger.d("UserProfile : " + userProfile);

                Log.d("test","로그인 성공!");

                redirectMainActivity();
            }
        });
    }
    private void redirectMainActivity() {
        startActivity(new Intent(this, udt_meeting.class));
        finish();
    }
    protected void redirectLoginActivity() {
        final Intent intent = new Intent(this, udt_meeting.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}
