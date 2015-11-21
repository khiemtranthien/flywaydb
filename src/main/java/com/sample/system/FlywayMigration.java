package com.sample.system;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlywayMigration {

	/** Tracking system operations. */
	private static final Logger LOGGER = LoggerFactory.getLogger(FlywayMigration.class);
	
	/** The migrate data source. */
	private DataSource migrateDataSource; 
	
	/** The enable migration. */
	private boolean enableMigration;
	
	/** The is baseline. */
	private boolean isBaseline;
	
	/** The migrate script prefix. */
	private String migrateScriptPrefix;
	
	/** The migrate script separator. */
	private String migrateScriptSeparator;
	
	/** The migrate script suffix. */
	private String migrateScriptSuffix;
	
	/** The migrate table. */
	private String migrateTable;
	
	/**
	 * Instantiates a new flyway migration.
	 */
	public FlywayMigration(){
	}
	
	/**
	 * Gets the migrate data source.
	 *
	 * @return the migrate data source
	 */
	public DataSource getMigrateDataSource() {
		return migrateDataSource;
	}

	public void setMigrateDataSource(DataSource migrateDataSource) {
		this.migrateDataSource = migrateDataSource;
	}

	public boolean isEnableMigration() {
		return enableMigration;
	}

	public void setEnableMigration(boolean enableMigration) {
		this.enableMigration = enableMigration;
	}

	public boolean isBaseline() {
		return isBaseline;
	}

	public void setBaseline(boolean isBaseline) {
		this.isBaseline = isBaseline;
	}

	public String getMigrateScriptPrefix() {
		return migrateScriptPrefix;
	}

	public void setMigrateScriptPrefix(String migrateScriptPrefix) {
		this.migrateScriptPrefix = migrateScriptPrefix;
	}

	public String getMigrateScriptSeparator() {
		return migrateScriptSeparator;
	}

	public void setMigrateScriptSeparator(String migrateScriptSeparator) {
		this.migrateScriptSeparator = migrateScriptSeparator;
	}

	public String getMigrateScriptSuffix() {
		return migrateScriptSuffix;
	}

	public void setMigrateScriptSuffix(String migrateScriptSuffix) {
		this.migrateScriptSuffix = migrateScriptSuffix;
	}

	public String getMigrateTable() {
		return migrateTable;
	}

	public void setMigrateTable(String migrateTable) {
		this.migrateTable = migrateTable;
	}

	public void migrateDatabase() {
		if(enableMigration){
			LOGGER.info("========================= Start Flyway Migration ============================");

			// Create the Flyway instance
			Flyway flyway = new Flyway();

			// Point it to the database
			flyway.setDataSource(migrateDataSource);

			// Set properties for migration
			flyway.setBaselineOnMigrate(true);
			flyway.setSqlMigrationPrefix(migrateScriptPrefix);
			flyway.setSqlMigrationSeparator(migrateScriptSeparator);
			flyway.setSqlMigrationSuffix(migrateScriptSuffix);
			flyway.setTable(migrateTable);
			flyway.repair();
			// Start the migration
			flyway.migrate();
			LOGGER.info("========================= Finish Flyway Migration ============================");
		}
	}
	
}
