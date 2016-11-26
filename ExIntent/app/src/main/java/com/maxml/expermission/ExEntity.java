package com.maxml.expermission;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Maxml on 26.11.2016.
 */
public class ExEntity implements Parcelable {

    private SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.US);
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy", Locale.US);

    private int id;
    private String name;
    private String description;
    private String location;
    private long timeStart;
    private long timeEnd;
    private List<String> imageUrls = new ArrayList<>();

    public ExEntity() {
    }

    private ExEntity(Parcel parcel) {
        id = parcel.readInt();
        name = parcel.readString();
        description = parcel.readString();
        location = parcel.readString();
        timeStart = parcel.readLong();
        timeEnd = parcel.readLong();
        parcel.readList(imageUrls, String.class.getClassLoader());
    }

    public String getTimeAndLocation() {
        String time = DATE_TIME_FORMAT.format(new Date(timeStart));
        return String.format("%s, %s", time, getLocation());
    }

    public String getFormattedEndTime() {
        return DATE_FORMAT.format(new Date(timeEnd));
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimeStart() {
        return timeStart;
    }

    public long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(long timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public static final Parcelable.Creator<ExEntity> CREATOR = new
            Parcelable.Creator<ExEntity>() {
                public ExEntity createFromParcel(Parcel in) {
                    return new ExEntity(in);
                }

                public ExEntity[] newArray(int size) {
                    return new ExEntity[size];
                }
            };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(location);
        parcel.writeLong(timeStart);
        parcel.writeLong(timeEnd);
        parcel.writeList(imageUrls);
    }

    @Override
    public String toString() {
        return "ExEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location+startTime='" + getTimeAndLocation() + '\'' +
                ", timeEnd=" + getFormattedEndTime() +
                ", imageUrls=" + imageUrls +
                '}';
    }
}
