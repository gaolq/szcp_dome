package com.yys.szcp.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yys
 * @since 2020-02-02
 */
public class DbRoleMenu {

    private static final long serialVersionUID = 1L;

	private Integer menuId;
	private Integer roleId;


	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


}
