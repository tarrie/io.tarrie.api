package io.tarrie.api.model.consumes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.tarrie.api.model.Location;
import io.tarrie.api.model.constants.CharacterLimit;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.awt.*;

@ApiModel
public class CreateGroup {

    @ApiModelProperty(value = "The ID of the user who is initiating the group creation")
    @NotNull
    public String userId;

    @ApiModelProperty(value = "The name of the new group")
    @NotNull
    @Size(min=1, max= CharacterLimit.SMALL)
    public String groupName;

    @ApiModelProperty(value = "The same thing as the groupID must be unique")
    @NotNull
    @Size(min=1, max= CharacterLimit.SMALL)
    public String groupHandle;

    @Size(min=0, max=CharacterLimit.LARGE)
    @ApiModelProperty(value = "The biography of the new group")
    public String groupBio;

    @ApiModelProperty(value = "The profile pic of the group")
    public Image groupProfilePic;

    @ApiModelProperty(value = "The location of the group")
    public Location location;


    @Override
    public String toString() {
        return "CreateGroup [userId=" + userId + ", groupName=" + groupName + ", groupHandle="+ groupHandle+"]";
    }
}