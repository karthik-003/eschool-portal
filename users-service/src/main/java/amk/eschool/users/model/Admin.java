package amk.eschool.users.model;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value = "2")
public class Admin extends User {

}
