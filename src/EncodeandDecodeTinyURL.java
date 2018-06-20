import java.util.HashMap;
import java.util.Map;

/**
 * Solution: Use HashMap to map corresponding integer and Url
 */
public class EncodeandDecodeTinyURL {
    Map<Integer, String> codeMap = new HashMap<>();
    int pos = 1;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        codeMap.put(pos, longUrl);
        return "http://tinyurl.com/" + pos++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeMap.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
