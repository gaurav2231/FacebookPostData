package com.postdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.postdata.Entity.PostEntity;
import com.restfb.DefaultFacebookClient;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.json.JsonValue;

@Service
public class FbApiService {
@Autowired
PostEntity postEntity;

	public PostEntity getInsight() {
		 String accessToken="EAAjdsncxpu4BAJb2kD8Ial6woN0JEYgoHf3YjAgrZCu72NDFNiU6UrWnMnKsNc64cgyZAquiVDzZAc9ZBtJXTSZCB1ZCCKZA0GUt3NJpOLitZBysSEywI0Nphzb0nj2pxC62VT8Vj9jOZBPdJBoryuIlFGdZCIkfKfSRSIIysS7DTzUTwlOKrsrxtx7HY8YotUYowNhgfax8Hd6ik0hrvR48kZAWlPWkS6pd1ZBTn2dpvRijbQZDZD";
		
	    // fetch Faceboook api data	 
			DefaultFacebookClient facebookClient = new com.restfb.DefaultFacebookClient(accessToken, com.restfb.Version.LATEST);
			JsonObject getExpired=facebookClient.fetchObject("1805257253087224/ads_posts?include_inline_create=true",JsonObject.class);
			JsonObject jsonData=new JsonObject(getExpired);
			
        //  fetch data from object and return after converting
			JsonArray dataarr = jsonData.get("data").asArray();
			String date = dataarr.get(0).asObject().get("created_time").toString();
			String message = dataarr.get(0).asObject().get("message").toString();
			String id = dataarr.get(0).asObject().get("id").toString();
			
			JsonObject paging = jsonData.get("paging").asObject();
			JsonObject cursors=paging.get("cursors").asObject();
            String before = cursors.get("before").asString();
            String after = cursors.get("after").asString();

			 System.out.println(after);

		PostEntity postobject=new PostEntity();
	       postobject.setCreatedtime(date);
	       postobject.setMessage(message);
	       postobject.setId(id);
	       postobject.setBefore(before);
	       postobject.setAfter(after);
			
 			 //System.out.println(dataarr);
           return postobject;

			
		}
	}


