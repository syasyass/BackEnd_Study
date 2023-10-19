package org.galapagos.domain.kakao.local;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class KakaoLocalResult {

   @SerializedName("documents")
   List<Local> locals;

   @SerializedName("meta")
   LocalMeta meta;
    
}