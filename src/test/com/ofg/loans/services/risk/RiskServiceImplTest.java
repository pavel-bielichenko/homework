package com.ofg.loans.services.risk;

import com.ofg.loans.model.LoanApplication;
import com.ofg.loans.risk.impl.IpCountRiskHandler;
import com.ofg.loans.risk.impl.TimeRangeRiskHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by pavel on 23.04.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class RiskServiceImplTest {

    @Mock
    private TimeRangeRiskHandler timeRangeHandler;

    @InjectMocks
    private RiskServiceImpl riskService;

    @Test
    public void testApprove() throws Exception {
        LoanApplication loanApplication = new LoanApplication();
        when(timeRangeHandler.checkLoanApplication(loanApplication)).thenReturn(true);

        Boolean approve = riskService.approve(loanApplication);

        assertTrue(approve);
    }
}