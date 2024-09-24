/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2028-08-13
 ******************************************************************************/
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*******************************************************************************
 *
 * Pentaho Big Data
 *
 * Copyright (C) 2002-2018 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package ${groupId}.hadoop.shim.${shimName};

import ${groupId}.di.core.exception.KettlePluginException;
import ${groupId}.hadoop.shim.HadoopConfiguration;
import ${groupId}.hadoop.shim.HadoopConfigurationFileSystemManager;
import ${groupId}.hadoop.shim.common.HadoopShimImpl;

import java.util.Properties;

public class HadoopShim extends HadoopShimImpl {
  @Override
  public void onLoad( HadoopConfiguration config, HadoopConfigurationFileSystemManager fsm ) throws Exception {
    registerExtraDatabaseTypes( config.getConfigProperties() );
    super.onLoad( config, fsm );
  }

  protected void registerExtraDatabaseTypes( Properties configuration ) throws KettlePluginException {
    String sparkSqlSimbaDriverName =
      configuration.getProperty( "sparksql.simba.driver", "com.simba.spark.jdbc41.Driver" );
    JDBC_POSSIBLE_DRIVER_MAP.put( "SparkSqlSimba", sparkSqlSimbaDriverName );
  }
}
