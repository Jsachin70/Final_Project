/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_part_1;

import java.io.IOException;
import net.sf.json.JSONArray;

import net.sf.json.JSONObject;

/**
 *
 * @author 1691504
 */
public class Project_part_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
         String json=utilities.FileReader.loadFileIntoString("json/tweets.json", "UTF-8");
       
         JSONObject mainobj=JSONObject.fromObject(json);  //main object
         JSONArray secondobj=mainobj.getJSONArray("statuses");   //Second Array
         
         for(int i=0;i<secondobj.size();i++)
         {
         JSONObject inside_statuses_obj=secondobj.getJSONObject(i);
         String create_at=inside_statuses_obj.getString("created_at");
         String id_str=inside_statuses_obj.getString("id_str");
         String text=inside_statuses_obj.getString("text");
         int retweet_count=inside_statuses_obj.getInt("retweet_count");
         JSONObject user_obj=inside_statuses_obj.getJSONObject("user");
         String name=user_obj.getString("name");
        // String description=user.getString("description");
          int friends_count=user_obj.getInt("friends_count");
          String created_at=user_obj.getString("created_at");
          String location=user_obj.getString("location");
          
          JSONObject entities_obj,url_obj,first_obj_inside_hashtags;
           JSONArray hashtags_array_obj,indices_array_obj;
          entities_obj=inside_statuses_obj.getJSONObject("entities");
          url_obj=entities_obj.getJSONObject("url");
          hashtags_array_obj=entities_obj.getJSONArray("hashtags");
          for(int j=0;j<hashtags_array_obj.size();j++)
          {
              first_obj_inside_hashtags=hashtags_array_obj.getJSONObject(j);
              indices_array_obj=first_obj_inside_hashtags.getJSONArray("indices");
              for(int k=0;k<indices_array_obj.size();k++)
              {
                int indices=indices_array_obj.getInt(k);
                System.out.println(indices);
              }
          }   
           //System.out.println(urls_array_obj);
           
        
         } 
        // TODO code application logic here
    }
    
}
