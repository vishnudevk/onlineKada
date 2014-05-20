package com.onlinekada.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinekada.model.User;

@Transactional
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> {

}
