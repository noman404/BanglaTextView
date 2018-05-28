[![](https://jitpack.io/v/noman404/BanglaTextView.svg)](https://jitpack.io/#noman404/BanglaTextView)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-BanglaTextView-green.svg?style=flat )]( https://android-arsenal.com/details/1/6963)
[![Build Status](https://travis-ci.org/noman404/BanglaTextView.svg?branch=master)](https://travis-ci.org/noman404/BanglaTextView)
[![API](https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=17)

## **Preview**
![Sample](https://github.com/noman404/BanglaTextView/blob/master/snap/sample.png?raw=true)

# **Dependencies**

- in your top level *build.gradle* file add the **jitpack** dependency 

     `maven { url 'https://jitpack.io' }`
- in application level *build.gradle* add the *BanglaTextView* dependency
 
     `implementation 'com.github.noman404:BanglaTextView:1.0.3'`

## **Usage**

From *.xml*

    <com.al.tobangla.views.BNTextView  
      android:layout_width="wrap_content"  
      android:layout_height="wrap_content"  
      android:text="21.00"  
      toBangla:processType="amount" />
      
From Java

    BNTextView bnTextView = new BNTextView(this);  
    bnTextView.setProcessType(ProcessType.AMOUNT);  
    bnTextView.setText("21.00");

## **Supported Conversions**

 - Date 
 - Number
 - Amount
 - Time
 - Ordinal Indicator (Date, Number, Today)
 - Current Date, Time

|Process Type  | Flag | Output|
|--|--|--|
|Date | DATE |২০১৮-০৫-০৭|
|Number| NUMBER |৭৫|
|Time| TIME |০৫:০৭|
|Amount | AMOUNT |৳ ৫৭|
|Today | TODAY |রবিবার|
|Date Ordinal Indicator  | ORDINAL\_INDICATOR\_FOR_DATE |১৬ই ডিসেম্বর, ১৯৭১|
|Number Ordinal Indicator  |ORDINAL\_INDICATOR\_FOR\_NUMERIC\_ORDER  |১৩ তম|
|Today Ordinal Indicator  | ORDINAL\_INDICATOR\_TODAY |০৭/০৫/২০১৮|
|Current Time | TIME_NOW |১২:০৯:২৫|
