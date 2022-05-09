package com.revature.services;
import junit.framework.*;



import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.junit.Before.*;

import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Optional;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.postgresql.util.PSQLException;

import com.revature.DAO.PGDaoClass;

import junit.framework.TestCase;




public class TestClassPlaceholder {
		
@Test
void GetAllDaoTest(){
	PGDaoClass pgd = new PGDaoClass();
	assertTrue(pgd.GetReimbursements().size() > 0);
}
	
	

}