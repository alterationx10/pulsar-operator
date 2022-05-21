package com.alterationx10.pulsar.admin

import org.apache.pulsar.client.admin.PulsarAdmin
import zio._
import scala.jdk.CollectionConverters._
import org.apache.pulsar.common.policies.data.TenantInfo

case class PulsarAdminServiceLive(adminClient: PulsarAdmin)
    extends PulsarAdminService {

  override def getTenants: Task[Seq[String]] =
    ZIO
      .fromCompletableFuture(adminClient.tenants().getTenantsAsync())
      .map(_.asScala.toSeq)

  override def getTenantInfo(tenant: String): Task[TenantInfo] =
    ZIO.fromCompletableFuture(adminClient.tenants().getTenantInfoAsync(tenant))

  override def createTenant(tenant: String, config: TenantInfo): Task[Unit] =
    ZIO
      .fromCompletableFuture(
        adminClient.tenants().createTenantAsync(tenant, config)
      )
      .unit

  def updateTenantInfo(tenant: String, config: TenantInfo): Task[Unit] =
    ZIO
      .fromCompletableFuture(
        adminClient.tenants().updateTenantAsync(tenant, config)
      )
      .unit

  override def deleteTenant(tenant: String, force: Boolean): Task[Unit] =
    ZIO
      .fromCompletableFuture(
        adminClient.tenants().deleteTenantAsync(tenant, force)
      )
      .unit

}
