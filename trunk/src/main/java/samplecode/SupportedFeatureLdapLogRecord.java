/*
 * Copyright 2008-2011 UnboundID Corp. All Rights Reserved.
 */
/*
 * Copyright (C) 2008-2011 UnboundID Corp. This program is free
 * software; you can redistribute it and/or modify it under the terms of
 * the GNU General Public License (GPLv2 only) or the terms of the GNU
 * Lesser General Public License (LGPLv2.1 only) as published by the
 * Free Software Foundation. This program is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details. You
 * should have received a copy of the GNU General Public License along
 * with this program; if not, see <http://www.gnu.org/licenses>.
 */
package samplecode;


import com.unboundid.util.Validator;


import java.util.logging.Level;
import java.util.logging.LogRecord;


import samplecode.annotation.Author;
import samplecode.annotation.CodeVersion;
import samplecode.annotation.Since;


/**
 * Provides LogRecord objects for clients that catch
 * {@code SupportedFeatureException} objects.
 */
@Author("terry.gardner@unboundid.com")
@Since("Dec 6, 2011")
@CodeVersion("1.0")
class SupportedFeatureLdapLogRecord
        implements LdapLogRecord
{

  static SupportedFeatureLdapLogRecord newSupportedFeatureLdapLogRecord(
          final SupportedFeatureException supportedFeatureException)
  {
    Validator.ensureNotNull(supportedFeatureException);
    return new SupportedFeatureLdapLogRecord(supportedFeatureException);
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public LogRecord getLogRecord(final Level level)
  {
    final StringBuilder builder = new StringBuilder();
    builder.append(String.format("%s is not supported.",
            supportedFeatureException.getControlOID()));
    return new LogRecord(level,builder.toString());
  }



  private SupportedFeatureLdapLogRecord(
          final SupportedFeatureException supportedFeatureException)
  {
    this.supportedFeatureException = supportedFeatureException;
  }



  private final SupportedFeatureException supportedFeatureException;
}
