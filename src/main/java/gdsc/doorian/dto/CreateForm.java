package gdsc.doorian.dto;

import gdsc.doorian.entity.Create;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CreateForm {
    private String title;
    private String content;
    public Create toEntity(){
        return new Create(null,title,content);
    }
}

