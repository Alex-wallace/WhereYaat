package ca.wallacemohawcollege.alex.whereya;

import com.microsoft.azure.storage.table.TableServiceEntity;

/**
 * Created by Stephen on 12/4/2016.
 */
public class meetingEntry extends TableServiceEntity {
    public meetingEntry(long meetingId, long creatorId) {
        this.partitionKey = String.valueOf(meetingId);
        this.rowKey = String.valueOf(creatorId);
    }

    public meetingEntry() { }

    long[] participents;
    long location;
    String[] chatlog;

    public long[] getParticipents() {
        return participents;
    }

    public void setParticipents(long[] participents) {
        this.participents = participents;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
        this.location = location;
    }

    public String[] getChatlog() {
        return chatlog;
    }

    public void setChatlog(String[] chatlog) {
        this.chatlog = chatlog;
    }
}
