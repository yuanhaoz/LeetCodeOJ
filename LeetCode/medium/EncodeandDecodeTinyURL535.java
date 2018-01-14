package medium;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL Add to List
 DescriptionHintsSubmissionsSolutions
 Total Accepted: 7025
 Total Submissions: 9441
 Difficulty: Medium
 Contributor: LeetCode
 Note: This is a companion problem to the System Design problem: Design TinyURL.
 TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * Created by yuanhao on 2017/5/5.
 */
public class EncodeandDecodeTinyURL535 {

    Map<String , String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int len = longUrl.length();
        String temp = "";
        if ((len & 1) == 0) {
            temp  = longUrl.substring(len/2, len) + longUrl.substring(0, len/2); // 加密后的算法
        } else {
            temp = longUrl.substring((len-1)/2, len) + longUrl.substring(0, (len-1)/2); // 加密后的算法
        }
        map.put(longUrl, temp);
        return temp;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String result = "";
        for (String key : map.keySet()) {
            String temp = map.get(key);
            if (temp.equals(shortUrl)){
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EncodeandDecodeTinyURL535 encodeandDecodeTinyURL535 = new EncodeandDecodeTinyURL535();
        String longurl = "hello world";
        longurl = "https://leetcode.com/problems/design-tinyurl";
        String mdUrl = encodeandDecodeTinyURL535.encode(longurl);
        System.out.println(mdUrl);
        String oldUrl = encodeandDecodeTinyURL535.decode(mdUrl);
        System.out.println(oldUrl);

    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));