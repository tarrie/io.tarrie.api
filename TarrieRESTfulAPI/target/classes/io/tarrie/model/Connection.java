package io.tarrie.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import io.tarrie.Utility;
import io.tarrie.database.contants.DbAttributes;
import io.tarrie.database.contants.DbConstants;
import io.tarrie.database.contants.EntityType;
import io.tarrie.database.exceptions.MalformedInputException;

/**
 * A connections is a
 * <ul>
 *     <li> CONTACT</li>
 *     <li> FOLLOW</li>
 *     <li> MEMBER</li>
 * </ul>
 */
@DynamoDBTable(tableName = DbConstants.BASE_TABLE)
public class Connection {
    protected String entityId;
    private String name;
    private String imgUrl;
    private int favorite;
    protected String contactId;
    private String rangeKey;
    private String memType;
    private Location loc;

    // primary key
    @DynamoDBRangeKey(attributeName= DbAttributes.SORT_KEY)
    public String getRangeKey() {
        return rangeKey;
    }
    public void setRangeKey(String rangeKey) {
        this.rangeKey = rangeKey;
    }

    // primary key
    @DynamoDBHashKey(attributeName = DbAttributes.HASH_KEY)
    public String getEntityId() {
        return entityId;
    }
    public void setEntityId(String id) {
        if (Utility.getEntityType(id).equals(EntityType.EVENT)){
            throw new MalformedInputException("Events can't be a Contact, Follow, or Group");
        }

        this.entityId = id;
    }

    @DynamoDBAttribute(attributeName = DbAttributes.LOC)
    public Location getLoc() {
        return loc;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
    public String getContactId() {
        return contactId;
    }

    @DynamoDBAttribute(attributeName = DbAttributes.IMG_PATH)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }



    @DynamoDBAttribute(attributeName = DbAttributes.NAME)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @DynamoDBAttribute(attributeName = DbAttributes.FAVE)
    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    @DynamoDBAttribute(attributeName = DbAttributes.DATA)
    public String getData() {
        return memType;
    }
    public void setData(String memType) {
        this.memType = memType;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

}