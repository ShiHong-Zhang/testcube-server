package presentation.model.admin.products {
	import application.controller.admin.products.EnvironmentsController;
	import application.controller.admin.products.ProductsController;
	import application.model.DomainObject;
	import application.model.grid.GridParameters;
	import application.model.products.Environment;
	import application.model.products.ProductsList;
	
	import flash.events.MouseEvent;
	import flash.xml.XMLNode;
	
	import mx.collections.ArrayList;
	
	import presentation.model.panels.CrudPM;
	
	import utils.ComboBoxUtils;
	
	public class CrudEnvironmentPM extends CrudPM {
		[Embed("/images/admin/environments-48.png")]
		private static const ENVIRONMENTS_LARGE:Class;
		
		public static const ENVIRONMENTS_SEARCH_REFRESH_EVENT:String = "ENVIRONMENTS_SEARCH_REFRESH_EVENT";
		
		[Inject]
		public var environmentsController:EnvironmentsController;
		[Inject]
		public var productsController:ProductsController;
		
		[Bindable]
		public var products:ArrayList;
		[Bindable]
		public var productSelectedIndex:int = ComboBoxUtils.NON_SELECTED_INDEX;
		
		public function CrudEnvironmentPM() {}
		
		[Init]
		override public function postConstructor():void {
			super.controller = environmentsController;
			
			loadProducts();
		}
		
		override public function get largeIcon():Class {
			return ENVIRONMENTS_LARGE;
		}
		
		override public function get modelName():String {
			return getMessageLocale("admin", "admin.administrator.environments.crud.object.name");
		}
		
		override public function getNewDomainObject():DomainObject{
			return new Environment() as DomainObject;
		}
		
		override public function getRefreshEventType():String {
			return ENVIRONMENTS_SEARCH_REFRESH_EVENT;
		}
		
		[Bindable]
		public function get environment():Environment {
			return super.getDomainObject() as Environment;
		}
		
		public function set environment(environment:Environment):void {
			return super.setDomainObject(environment as DomainObject);
		}
		
		private function loadProducts():void {
			productsController.searchByParameters(toProductsModel, new GridParameters(ComboBoxUtils.COMBOBOX_LIMIT));
		}
		
		private function toProductsModel(xml:XMLNode):void{
			var products:ProductsList = getFlexXBEngineInstance().deserialize(new XML(xml), ProductsList) as ProductsList;
			this.products = products.products;
			
			productSelectedIndex = ComboBoxUtils.getSelected(this.products, environment.product);
		}
		
		override public function onSaveNewObject():void {
			this.environment = getNewDomainObject() as Environment;
		}
	}
}