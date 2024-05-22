package ro.consutsescu.springdocnestedoneofissues.apiobjects;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.Getter;
import lombok.Setter;


@JsonTypeInfo(use = Id.NAME, property = "type")
@JsonSubTypes({
		@Type(ParentType1.class),
		@Type(ParentType2.class)
})
@Getter
@Setter
public abstract class AbstractParent {
	private int id;

}

@Getter
@Setter
class ParentType1 extends AbstractParent {

	private String parentType1Param;
	private AbstractChild abstractChild;

}

@Getter
@Setter
class ParentType2 extends AbstractParent {

	private String parentType2Param;

}
