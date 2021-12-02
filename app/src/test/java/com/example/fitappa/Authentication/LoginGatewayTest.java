package com.example.fitappa.Authentication;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

public class LoginGatewayTest {

    @Mock
    private OpensActivityWithProfile view;

    @Captor
    private ArgumentCaptor<LoginGateway> loginGatewayArgumentCaptor;

    @Before
    public void setUp() throws Exception {
        GatewayInteractor presenter = new LoginPresenter(view);
        LoginGateway loginGateway = new LoginGateway(presenter);
    }

    @Test
    public void testLogin() {
        loginGatewayArgumentCaptor.getValue().login("tester1@test.com", "test123");
        verify(loginGatewayArgumentCaptor).capture();
    }
}