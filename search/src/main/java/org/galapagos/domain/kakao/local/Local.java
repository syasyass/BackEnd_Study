package org.galapagos.domain.kakao.local;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Local {

   @SerializedName("place_name")
   String placeName;

   @SerializedName("place_url")
   String placeUrl;
	   
   @SerializedName("address_name")
   String addressName;

   @SerializedName("category_group_code")
   String categoryGroupCode;

   @SerializedName("category_group_name")
   String categoryGroupName;

   @SerializedName("category_name")
   String categoryName;

   @SerializedName("distance")
   String distance;

   @SerializedName("id")
   String id;

   @SerializedName("phone")
   String phone;

   @SerializedName("road_address_name")
   String roadAddressName;

   @SerializedName("x")
   String x;

   @SerializedName("y")
   String y;
    
}