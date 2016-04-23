package com.ofg.loans.services.risk;

import com.ofg.loans.risk.impl.IpCountRiskHandler;
import com.ofg.loans.risk.impl.TimeRangeRiskHandler;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by pavel on 23.04.16.
 */

@RunWith(MockitoJUnitRunner.class)
public class RiskServiceImplTest extends TestCase {

    @Mock
    private TimeRangeRiskHandler timeRangeHandler;

    @Mock
    private IpCountRiskHandler ipHandler;

    @Test
    public void testApprove() throws Exception {

    }
}