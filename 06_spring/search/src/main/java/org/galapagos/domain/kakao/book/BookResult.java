package org.galapagos.domain.kakao.book;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class BookResult {

   @SerializedName("documents")
   List<Book> books;

   @SerializedName("meta")
   Meta meta;
    
}