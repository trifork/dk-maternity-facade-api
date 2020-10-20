/*
 * The MIT License
 *
 * Original work sponsored and donated by The Danish Health Data Authority (http://www.sundhedsdatastyrelsen.dk)
 *
 * Copyright (C) 2017 The Danish Health Data Authority (http://www.sundhedsdatastyrelsen.dk)
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dk.sds.nsp.maternity.facade.common.util;

import dk.sdsd.nsp.slalog.api.SLALogConfig;
import dk.sdsd.nsp.slalog.api.SLALogItem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * This SlaLogger is used for SLA logging http calls as is a requirement by NSP.
 */
public class SlaLogger {

    private static final Logger logger = LogManager.getLogger(SlaLogger.class);

    private static final Integer lock = 1;
    public static final String SHORT_APP_NAME = "maternity-web-facade";
    private static SLALogConfig slaLogInstance;

    private final String name;

    public SlaLogger(String name) {
        this.name = name;
        synchronized (lock) {
            if (slaLogInstance == null) {
                slaLogInstance = new SLALogConfig(SHORT_APP_NAME, SHORT_APP_NAME);
            }
        }
    }

    /**
     * Creates a SLAlog Item
     * @param httpServletRequest The servlet request context
     * @param startTimeNano Start time in nano seconds
     * @param startTimeMillis Start time in milliseconds seconds
     * @param e optional exception
     * @return SlaLogItem
     */
    private SLALogItem createSlaLogItem(HttpServletRequest httpServletRequest, Long startTimeNano, Long startTimeMillis, Exception e){
        final String errorMessage = e == null ? null : e.getMessage();
        SLALogItem logItem = slaLogInstance.getSLALogger().createLogItem(SHORT_APP_NAME + "." + name, SHORT_APP_NAME + "." + name);

        // SLA headers that is trackable in REST interfaces
        logItem.setStartTime(startTimeNano, startTimeMillis);
        logItem.setClientIP(httpServletRequest);
        logItem.setSourceEndpoint(httpServletRequest.getRequestURI());
        logItem.setSourceOperation(httpServletRequest.getMethod());
        logItem.setEndTime(System.nanoTime(), System.currentTimeMillis());

        if (errorMessage == null) {
            logItem.setCallResultOk();
        } else {
            logItem.setCallResultError(errorMessage);
        }
        return logItem;
    }
    /**
     * create and stores a SLA log
     * @param httpServletRequest The servlet request context
     * @param startTimeNano Start time in nano seconds
     * @param startTimeMillis Start time in milliseconds seconds
     * @param cause optional exception
     */
    public void addSlaLog(HttpServletRequest httpServletRequest, Long startTimeNano, Long startTimeMillis, Exception cause) {
        try {
            createSlaLogItem(httpServletRequest, startTimeNano, startTimeMillis, cause).store();
        } catch (Exception e) {
            logger.error("Could not create SLA LogItem", e);
        }
    }

    /**
     * create and stores a SLA log
     * @param request The servlet request context
     * @param startTimeNano Start time in nano seconds
     * @param startTimeMillis Start time in milliseconds seconds
     */
    public void addSlaLog(HttpServletRequest request, long startTimeNano, long startTimeMillis) {
        addSlaLog(request, startTimeNano, startTimeMillis, null);
    }
}
