/*
 * Copyright (c) 2002-2016, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.lobbycal.web;

import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.portal.web.xpages.XPage;
import fr.paris.lutece.portal.util.mvc.xpage.MVCApplication;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.portal.util.mvc.xpage.annotations.Controller;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * This class provides a simple implementation of an XPage
 */
@Controller( xpageName = "lobbycal" , pageTitleI18nKey = "lobbycal.xpage.lobbycal.pageTitle" , pagePathI18nKey = "lobbycal.xpage.lobbycal.pagePathLabel" )
public class LobbycalApp extends MVCApplication
{
    private static final String TEMPLATE_XPAGE = "/skin/plugins/lobbycal/home.html";
    private static final String VIEW_HOME = "home";
    private static final String MARK_SERVER_URL = "server_url";
    private static final String MARK_LANGUAGE = "language";
    private static final String PROPERTY_SERVER_URL = "lobbycal.serverUrl";
    private static final String PROPERTY_LANGUAGE = "lobbycal.language";
    private static final String DEFAULT_SERVER_URL = "http://localhost:8080";
    private static final String DEFAULT_LANGUAGE = "en";
    private static final long serialVersionUID = 1L;
    /**
     * Returns the content of the page lobbycal. 
     * @param request The HTTP request
     * @return The view
     */
    @View( value = VIEW_HOME , defaultView = true )
    public XPage viewHome( HttpServletRequest request )
    {
        String strServerUrl = AppPropertiesService.getProperty(PROPERTY_SERVER_URL, DEFAULT_SERVER_URL );
        String strLanguage = AppPropertiesService.getProperty(PROPERTY_LANGUAGE, DEFAULT_LANGUAGE );
        Locale locale = new Locale( strLanguage );
        Map<String,Object> model = getModel();
        model.put( MARK_SERVER_URL , strServerUrl );
        model.put( MARK_LANGUAGE, strLanguage );
        
        return getXPage( TEMPLATE_XPAGE, locale , model );
    }
}
