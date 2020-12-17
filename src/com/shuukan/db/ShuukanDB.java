package com.shuukan.db;

import com.shuukan.cli.ShuukanAppInfo;
import net.harawata.appdirs.AppDirs;
import net.harawata.appdirs.AppDirsFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShuukanDB {
    private AppDirs appDirs;
    private Connection db;

    public ShuukanDB() {
        appDirs = AppDirsFactory.getInstance();
        System.out.println("User data dir: " + appDirs.getUserDataDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion()));
        System.out.println("User data dir (roaming): " + appDirs.getUserDataDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion(), true));
        System.out.println("User config dir: " + appDirs.getUserConfigDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion()));
        System.out.println("User config dir (roaming): " + appDirs.getUserConfigDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion(), true));
        System.out.println("User cache dir: " + appDirs.getUserCacheDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion()));
        System.out.println("User log dir: " + appDirs.getUserLogDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion()));
        System.out.println("Site data dir: " + appDirs.getSiteDataDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion()));
        System.out.println("Site data dir (multi path): " + appDirs.getSiteDataDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion(), true));
        System.out.println("Site config dir: " + appDirs.getSiteConfigDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion()));
        System.out.println("Site config dir (multi path): " + appDirs.getSiteConfigDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion(), true));
        System.out.println("Shared dir: " + appDirs.getSharedDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion()));

        initializePaths();

        try {
            db = DriverManager.getConnection("jdbc:sqlite:" + getDBFilePath());
            if (db != null) {
                DatabaseMetaData meta = db.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            } else {
                System.out.println("null db");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializePaths() {
        (new File(appDirs.getUserDataDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion()))).mkdirs();
    }

    private String getDBFilePath() {
        return appDirs.getUserDataDir(ShuukanAppInfo.getAppName(), ShuukanAppInfo.getAppVersion()) + "\\store.db";
    }
}
