package com.example.shuqq.mywechat.download;

/**
 * Created by Shuqq on 2017/7/18.
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
