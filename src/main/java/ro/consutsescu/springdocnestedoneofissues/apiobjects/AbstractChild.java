package ro.consutsescu.springdocnestedoneofissues.apiobjects;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.Getter;
import lombok.Setter;


@JsonTypeInfo(use = Id.NAME, property = "type")
@JsonSubTypes({
        @Type(ChildType1.class),
        @Type(ChildType2.class)
})
@Getter
@Setter
public abstract class AbstractChild {
    private int id;
}

@Getter
@Setter
class ChildType1 extends AbstractChild {
    private String childType1Param;

}

@Getter
@Setter
class ChildType2 extends AbstractChild {
    private String childType2Param;
}
