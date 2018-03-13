package io.yostajsc.chat.models;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Phuc-Hau Nguyen on 12/3/2016.
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef({ChatType.SEND, ChatType.RECEIVE, ChatType.UNDEFINED})

public @interface ChatType {
    int UNDEFINED = -1;
    int SEND = 0;
    int RECEIVE = 1;
}

