package io.tarrie.api.model.consumes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.tarrie.api.model.EventPrivacy;
import io.tarrie.api.model.EventTime;
import io.tarrie.api.model.HashTag;
import io.tarrie.api.model.Location;
import io.tarrie.api.model.constants.CharacterLimit;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.awt.*;
import java.util.Collection;

@ApiModel
public class CreateEvent {

    @ApiModelProperty(value = "The time of the event")
    @NotNull
    public EventTime eventTime;

    @ApiModelProperty(value = "The id of user creating event")
    @NotNull
    public String userId;

    @ApiModelProperty(value = "The title of the event")
    @Size(min=1, max= CharacterLimit.SMALL)
    @NotNull
    public String eventTitle;

    @ApiModelProperty(notes = "The privacy specifications of the events")
    @NotNull
    EventPrivacy eventPrivacy;

    @ApiModelProperty(value = "The event location (if left empty the event is virtual")
    public Location eventLocation;

    @ApiModelProperty(value = "If left empty then the user is creating a event under own account, and not a group account")
    public String groupId;

    @ApiModelProperty(value = "The profile pic of the event, if left empty a default pic is provided")
    public Image eventProfilePic;

    @ApiModelProperty(value = "Collection of entityIds invited to event")
    public Collection<String> invitedEntityIds;

    @ApiModelProperty(value = "The description of the event")
    @Size(min=0, max= CharacterLimit.LARGE)
    public String eventDescription;


    @ApiModelProperty(notes = "hash tags associated with event")
    Collection<HashTag> hashTags;
}