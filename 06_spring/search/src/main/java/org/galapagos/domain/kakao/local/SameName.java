package org.galapagos.domain.kakao.local;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class SameName {

   @SerializedName("keyword")
   String keyword;

   @SerializedName("region")
   List<String> region;

   @SerializedName("selected_region")
   String selectedRegion;
    
}