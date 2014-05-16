// default package
// Generated 16 May, 2014 1:31:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * UserPrivilage generated by hbm2java
 */
public class UserPrivilage implements java.io.Serializable {

	private int privilageId;
	private String privilageName;
	private Boolean editUser;
	private Boolean editProduct;
	private Boolean orderProduct;
	private Set users = new HashSet(0);

	public UserPrivilage() {
	}

	public UserPrivilage(int privilageId) {
		this.privilageId = privilageId;
	}

	public UserPrivilage(int privilageId, String privilageName,
			Boolean editUser, Boolean editProduct, Boolean orderProduct,
			Set users) {
		this.privilageId = privilageId;
		this.privilageName = privilageName;
		this.editUser = editUser;
		this.editProduct = editProduct;
		this.orderProduct = orderProduct;
		this.users = users;
	}

	public int getPrivilageId() {
		return this.privilageId;
	}

	public void setPrivilageId(int privilageId) {
		this.privilageId = privilageId;
	}

	public String getPrivilageName() {
		return this.privilageName;
	}

	public void setPrivilageName(String privilageName) {
		this.privilageName = privilageName;
	}

	public Boolean getEditUser() {
		return this.editUser;
	}

	public void setEditUser(Boolean editUser) {
		this.editUser = editUser;
	}

	public Boolean getEditProduct() {
		return this.editProduct;
	}

	public void setEditProduct(Boolean editProduct) {
		this.editProduct = editProduct;
	}

	public Boolean getOrderProduct() {
		return this.orderProduct;
	}

	public void setOrderProduct(Boolean orderProduct) {
		this.orderProduct = orderProduct;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}