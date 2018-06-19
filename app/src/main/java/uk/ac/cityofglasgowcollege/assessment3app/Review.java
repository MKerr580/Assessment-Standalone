package uk.ac.cityofglasgowcollege.assessment3app;

/**
 * Created by 30130705 on 19/02/2018.
 */

public class Review {
    private Integer userrating;
    private String usercomment;
    private Integer locationid;
    private String usersname;
    private String datesubmission;

    public Review(){

    }
    public Review( String usersname, String usercomment, Integer userrating,Integer locationid,String datesubmission) {

        this.userrating = userrating;
        this.usercomment = usercomment;
        this.locationid = locationid;
        this.usersname = usersname;
        this.datesubmission = datesubmission;
    }
    public Integer getuserrating() {
        return userrating;
    }

    public void setuserrating(Integer userrating) {
        this.userrating = userrating;
    }

    public String getusercomment() {
        return usercomment;
    }

    public void setusercomment(String usercomment) {
        this.usercomment = usercomment;
    }

    public Integer getlocationid() {
        return locationid;
    }

    public void setlocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public String getusersname() {
        return usersname;
    }

    public void setusersname(String usersname) {
        this.usersname = usersname;
    }

    public String getdatesubmission() {
        return datesubmission;
    }

    public void setdatesubmission(String datesubmission) {
        this.datesubmission = datesubmission;
    }

}
