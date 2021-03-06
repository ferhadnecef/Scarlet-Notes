package com.bijoysingh.quicknote

import android.app.Application
import com.bijoysingh.quicknote.firebase.FirebaseRemoteDatabase
import com.bijoysingh.quicknote.scarlet.ScarletConfig
import com.evernote.android.job.JobManager
import com.maubis.scarlet.base.config.CoreConfig
import com.maubis.scarlet.base.note.reminders.ReminderJobCreator

class Scarlet : Application() {

  override fun onCreate() {
    super.onCreate()
    CoreConfig.instance = ScarletConfig(this)
    CoreConfig.instance.themeController().setup(this)
    CoreConfig.instance.authenticator().setup(this)
    CoreConfig.instance.remoteConfigFetcher().setup(this)
    JobManager.create(this).addJobCreator(ReminderJobCreator())
  }

  companion object {
    var firebase: FirebaseRemoteDatabase? = null
  }
}