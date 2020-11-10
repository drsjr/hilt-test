package tour.donnees.testhilt.mapper

interface EntityMapper<ResponseModel, DomainModel> {

    fun mapFromEntity(response: ResponseModel): DomainModel

    fun mapToEntity(model: DomainModel): ResponseModel
}