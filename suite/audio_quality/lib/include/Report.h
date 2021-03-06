/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

#ifndef CTSAUDIO_REPORT_H
#define CTSAUDIO_REPORT_H

#include <list>

#include <utils/String8.h>
#include "FileUtil.h"
/**
 * Class to generate report
 */
class Report: public FileUtil {
public:
    /**
     * returns static instance of Report
     * report without dir name, for the 1st call, will only print to stdout.
     * This mode is necessary to prevent creating tons of reports during unit testing
     */
    static Report* Instance(const char* dirName = NULL);
    // should be called before finishing to flush the report to file system
    static void Finalize();

    void addCasePassed(const android::String8& name);
    void addCaseFailed(const android::String8& name);
    void printf(const char* fmt, ...);

private:
    Report();
    ~Report();
    bool init(const char* dirName);
    void writeSummary();

private:
    static Report* mInstance;
    std::list<android::String8> mPassedCases;
    std::list<android::String8> mFailedCases;
};


#endif // CTSAUDIO_REPORT_H
