package com.xuwenxing.bbtv.util;

import com.vdurmont.emoji.EmojiParser;

/**
 * Created by xuwx on 2018/9/20.
 */
public class StringUtil {

    public static void main(String[] args) {
        String str = "An :muscle:awesome :smiley:string &#128516;with a few :wink:emojis!";
        String result = EmojiParser.parseToUnicode(str);
        System.out.println(result);
    }
}
