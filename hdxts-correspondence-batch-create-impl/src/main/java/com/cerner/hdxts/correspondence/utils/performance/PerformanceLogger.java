package com.cerner.hdxts.correspondence.utils.performance;

import java.util.UUID;

import com.cerner.edi.logging.BPMPerfLogger;

/**
 * This class is a wrapper to BPM performance logging and logs messages with unique ID associated per transaction using threadlocal.
 * 
 * @author DS042009
 */
public class PerformanceLogger
{
    // unique Id that will be associated to thread local.
    private static ThreadLocal<String> context = new ThreadLocal<String>();

    private static String get()
    {
        return context.get();
    }

    /**
     * This method associates unique id to thread local.
     * 
     * @param id
     */
    private static void setUniqueID()
    {
        context.set(UUID.randomUUID().toString());
    }

    /**
     * This removes uniqueID from local thread context.
     */
    private static void removeUniqueID()
    {
        context.remove();
    }

    /**
     * This method should be strictly called in entry point of domainLookupService.
     * 
     * @param name
     */
    public static void processStart(String name)
    {
        setUniqueID();
        BPMPerfLogger.processStart(get(), name);
    }

    /**
     * This method should be strictly called in exit point of domainLookupService.
     * 
     * @param name
     */
    public static void processEnd(String name)
    {

        BPMPerfLogger.processEnd(get(), name);
        removeUniqueID();
    }

    /**
     * This method should be strictly called in exit point of domainLookupService and if transaction failed.
     * 
     * @param name
     */
    public static void processFail(String name)
    {

        BPMPerfLogger.processFail(get(), name);
        removeUniqueID();

    }

    /**
     * This method should be strictly called after processStart.
     * 
     * @param name
     */
    public static void serviceStart(String name)
    {
        if (get() != null)
        {
            BPMPerfLogger.serviceStart(get(), name);
        }

    }

    /**
     * This method should be called strictly called after processStart and serviceStart.
     * 
     * @param name
     */
    public static void serviceEnd(String name)
    {
        if (get() != null)
        {
            BPMPerfLogger.serviceEnd(get(), name);
        }

    }

    /**
     * This method should be called strictly called after processStart and serviceStart.
     * 
     * @param name
     */
    public static void serviceFail(String name)
    {
        if (get() != null)
        {
            BPMPerfLogger.serviceFail(get(), name);
        }
    }

}