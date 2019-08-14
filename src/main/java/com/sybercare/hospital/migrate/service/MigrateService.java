package com.sybercare.hospital.migrate.service;

import com.sybercare.hospital.common.utils.UserException;

public interface MigrateService {
	void doMigrate() throws UserException;
}
