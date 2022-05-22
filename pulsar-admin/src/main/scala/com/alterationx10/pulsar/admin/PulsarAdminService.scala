package com.alterationx10.pulsar.admin

import zio._
import org.apache.pulsar.common.policies.data.TenantInfo

trait PulsarAdminService {

  def getTenants: Task[Seq[String]]
  def getTenantInfo(tenant: String): Task[TenantInfo]
  def createTenant(tenant: String, config: TenantInfo): Task[Unit]
  def updateTenantInfo(tenant: String, config: TenantInfo): Task[Unit]
  def deleteTenant(tenant: String, force: Boolean = false): Task[Unit]

  def getNamespaces(tenant: String): Task[Seq[String]]
  def createNamespace(name: String): Task[Unit]
  def deleteNamespace(name: String, force: Boolean = false): Task[Unit]

}
