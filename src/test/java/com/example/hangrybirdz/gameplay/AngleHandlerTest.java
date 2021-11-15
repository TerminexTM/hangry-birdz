package com.example.hangrybirdz.gameplay;

import com.example.hangrybirdz.gameplay.*;
import com.example.hangrybirdz.gameplay.interfaces.IAngleGetter;
import com.example.hangrybirdz.gameplay.interfaces.IAngleHandler;
import com.example.hangrybirdz.gameplay.interfaces.IAngleIntegerValidator;
import com.example.hangrybirdz.gameplay.interfaces.IAngleRangeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.*;

public class AngleHandlerTest {


    private IAngleGetter angleGetter;
    private IAngleIntegerValidator angleIntegerValidator;
    private IAngleRangeValidator angleRangeValidator;
    private IAngleHandler angleHandler;


    @BeforeEach
    public void startup() {
        this.angleGetter = mock(AngleGetter.class);
        this.angleIntegerValidator = mock(AngleIntegerValidator.class);
        this.angleRangeValidator = mock(AngleRangeValidator.class);

        this.angleHandler = new AngleHandler(angleGetter, angleIntegerValidator, angleRangeValidator);
    }


    @Test
    public void givenRoundBeginsCallGetInputOnce(){
        when(angleGetter.getInput()).thenReturn("1");
        when(angleIntegerValidator.IsInteger("1")).thenReturn(true);
        when(angleRangeValidator.isInRange(1)).thenReturn(true);
        angleHandler.getAngle();
        verify(angleGetter,times(1)).getInput();
    }

    @Test
    public void givenOneCallIsIntegerOnce(){
        when(angleGetter.getInput()).thenReturn("1");
        when(angleIntegerValidator.IsInteger("1")).thenReturn(true);
        when(angleRangeValidator.isInRange(1)).thenReturn(true);
        angleHandler.getAngle();
        verify(angleIntegerValidator,times(1)).IsInteger("1");
    }

    @Test
    public void givenOneCallIsInRangeOnce(){
        when(angleGetter.getInput()).thenReturn("1");
        when(angleIntegerValidator.IsInteger("1")).thenReturn(true);
        when(angleRangeValidator.isInRange(1)).thenReturn(true);
        angleHandler.getAngle();
        verify(angleRangeValidator,times(1)).isInRange(1);
    }

//    @Test
//    public void givenBobLoopUntilTimeout() {
//        when(angleGetter.getInput()).thenReturn("Bob");
//        when(angleIntegerValidator.IsInteger("Bob")).thenReturn(false);
//        Instant start = Instant.now();
//        Instant end = Instant.now();
//        Duration timeout = Duration.between(start, end);
//        timeout.plusSeconds(2);
//        assertTimeoutPreemptively(timeout, () -> angleHandler.getAngle() );
//
//    }
}
