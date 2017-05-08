package fr.imanzo;


import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.google.common.io.BaseEncoding;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by manzo on 07/05/17.
 */
@RestController
public class IdentifyController {
    @Autowired
    private Environment env;

    @ResponseBody
    @RequestMapping(value = "/identify/{id}", method = RequestMethod.GET, produces = "application/json")
    public String index(@PathVariable("id") String id) throws IOException, ParseException {
        return getIdentifer(id);
    }

   private String getIdentifer(String id) throws IOException, ParseException {
       RestTemplate restTemplate = new RestTemplate();
       String uri = createUri(id);
       return restTemplate.getForObject(uri, String.class);
    }
    private String createUri(String id ){
        String host = env.getProperty("siegfried.host");
        String port = env.getProperty("siegfried.port");
        String base = env.getProperty("siegfried.base");
       return "http://"+host+":"+port+base+"/"+id+"?base64=true&format=json";
    }

}
