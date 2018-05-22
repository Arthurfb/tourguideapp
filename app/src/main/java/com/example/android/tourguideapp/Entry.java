package com.example.android.tourguideapp;

//Implement Parcelable to send information to other activities. More information and code about
// implementing Parcelable can be found in this tutorial:
// https://www.youtube.com/watch?v=WBbsvqSu0is

import android.os.Parcel;
import android.os.Parcelable;

public class Entry implements Parcelable {
    public static final Creator<Entry> CREATOR = new Creator<Entry>() {
        @Override
        public Entry createFromParcel(Parcel in) {
            return new Entry(in);
        }

        @Override
        public Entry[] newArray(int size) {
            return new Entry[size];
        }
    };
    private int mEntryNameId;
    private int mEntryPictureId;
    private int mEntryIconId;
    private int mEntryInfoId;


    public Entry(int entryNameId, int entryPictureId, int entryIconId, int entryInfoId) {
        mEntryNameId = entryNameId;
        mEntryPictureId = entryPictureId;
        mEntryIconId = entryIconId;
        mEntryInfoId = entryInfoId;
    }

    protected Entry(Parcel in) {
        mEntryNameId = in.readInt();
        mEntryPictureId = in.readInt();
        mEntryInfoId = in.readInt();
    }

    public int getmEntryNameId() {
        return mEntryNameId;
    }

    public int getmEntryPicutreId() {
        return mEntryPictureId;
    }

    public int getmEntryIconId() {
        return mEntryIconId;
    }

    public int getmEntryInfoId() {
        return mEntryInfoId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mEntryNameId);
        parcel.writeInt(mEntryPictureId);
        parcel.writeInt(mEntryInfoId);
    }
}
