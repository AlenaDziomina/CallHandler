package by.grouk.callhandler.model;

import java.util.Date;
import java.util.Objects;

/**
 * Phone call model
 */
public class PhoneCall {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date callDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PhoneCall phoneCall = (PhoneCall) o;
        return Objects.equals(firstName, phoneCall.firstName) &&
                Objects.equals(lastName, phoneCall.lastName) &&
                Objects.equals(phoneNumber, phoneCall.phoneNumber) &&
                Objects.equals(callDate, phoneCall.callDate);
    }

    @Override public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, callDate);
    }

    @Override public String toString() {
        return "PhoneCall{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", callDate=" + callDate +
                '}';
    }
}
