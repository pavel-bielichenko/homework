package com.ofg.loans.services;

import com.ofg.loans.dao.clientDao.ClientDao;
import com.ofg.loans.model.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by pavel on 24.04.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    private static final Long ID = 1L;
    private static final String USERNAME = "testUsername";

    @InjectMocks
    private ClientServiceImpl clientServiceMock;

    @Mock
    private ClientDao clientDaoMock;

    @Mock
    private Client clientMock;

    @Test
    public void testFindById() throws Exception {
        Mockito.when(clientDaoMock.findById(ID)).thenReturn(clientMock);

        Client client = clientDaoMock.findById(ID);
        assertEquals(clientMock, client);
    }

    @Test
    public void testFindByUsername() throws Exception {
        Mockito.when(clientDaoMock.findByUsername(USERNAME)).thenReturn(clientMock);

        Client client = clientDaoMock.findByUsername(USERNAME);
        assertEquals(clientMock, client);
    }
}