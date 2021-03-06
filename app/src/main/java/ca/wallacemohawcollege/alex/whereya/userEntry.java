package ca.wallacemohawcollege.alex.whereya;

import com.microsoft.azure.storage.table.TableServiceEntity;

/**
 * Created by Stephen on 12/4/2016.
 */
public class userEntry extends TableServiceEntity {
    public userEntry(String userName, String email) {
        this.partitionKey = userName;
        this.rowKey = email;
    }

    public userEntry() { }

    String country;
    int gender;
    long[] friends;
    long[] favorites;
    String Password;
    String Question;
    String Answer;

    public String getCountry() {return country;}

    public void setCountry(String country) {this.country = country;}

    public int getGender() {return gender;}

    public void setGender(int gender) {this.gender = gender;}

    public long[] getFriends() {
        return friends;
    }

    public void setFriends(long[] friends) {
        this.friends = friends;
    }

    public long[] getFavorites() {
        return favorites;
    }

    public void setFavorites(long[] favorites) {
        this.favorites = favorites;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
